package nl.han.ica.icss.parser;

import java.util.Stack;


import nl.han.ica.datastructures.HANStack;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {
	
	//Accumulator attributes:
	private AST ast;

	//Use this to keep track of the parent nodes when recursively traversing the ast
	private IHANStack<ASTNode> currentContainer;

	public ASTListener() {
		ast = new AST();
		currentContainer = new HANStack<>();
	}
    public AST getAST() {
        return ast;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterStylesheet(ICSSParser.StylesheetContext ctx) {
        currentContainer.push(new Stylesheet());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitStylesheet(ICSSParser.StylesheetContext ctx) {
        ast.root = (Stylesheet) currentContainer.pop();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterStylerule(ICSSParser.StyleruleContext ctx) {
        currentContainer.push(new Stylerule());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitStylerule(ICSSParser.StyleruleContext ctx) {
        Stylerule latestRule = (Stylerule) currentContainer.pop();
        currentContainer.peek().addChild(latestRule);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterSelector(ICSSParser.SelectorContext ctx) {
        var selector = ctx.getText();

        switch (selector.charAt(0)) {
            case '#': currentContainer.push(new IdSelector(selector));
                break;
            case '.': currentContainer.push(new ClassSelector(selector));
                break;
            default: currentContainer.push(new TagSelector(selector));
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitSelector(ICSSParser.SelectorContext ctx) {
        Selector selector = (Selector) currentContainer.pop();
        currentContainer.peek().addChild(selector);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterStylebody(ICSSParser.StylebodyContext ctx) {
        Declaration declaration = new Declaration();
        declaration.property = new PropertyName(ctx.getChild(0).getText());
        currentContainer.push(declaration);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitStylebody(ICSSParser.StylebodyContext ctx) {
        Declaration declaration = (Declaration) currentContainer.pop();
        currentContainer.peek().addChild(declaration);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterSizeLiteral(ICSSParser.SizeLiteralContext ctx) {
        if (ctx.PIXELSIZE() != null) {
            currentContainer.push(new PixelLiteral(ctx.getText()));
        } else if (ctx.PERCENTAGE() != null) {
            currentContainer.push(new PercentageLiteral(ctx.getText()));
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitSizeLiteral(ICSSParser.SizeLiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
        currentContainer.peek().addChild(literal);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void enterColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        currentContainer.push(new ColorLiteral(ctx.getText()));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     *
     * @param ctx
     */
    @Override
    public void exitColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        Literal literal = (Literal) currentContainer.pop();
        currentContainer.peek().addChild(literal);
    }
}