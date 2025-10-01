// Generated from ICSS.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ICSSParser}.
 */
public interface ICSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylerule}.
	 * @param ctx the parse tree
	 */
	void enterStylerule(ICSSParser.StyleruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylerule}.
	 * @param ctx the parse tree
	 */
	void exitStylerule(ICSSParser.StyleruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylebody}.
	 * @param ctx the parse tree
	 */
	void enterStylebody(ICSSParser.StylebodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylebody}.
	 * @param ctx the parse tree
	 */
	void exitStylebody(ICSSParser.StylebodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#sizeOption}.
	 * @param ctx the parse tree
	 */
	void enterSizeOption(ICSSParser.SizeOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#sizeOption}.
	 * @param ctx the parse tree
	 */
	void exitSizeOption(ICSSParser.SizeOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#sizeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSizeLiteral(ICSSParser.SizeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#sizeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSizeLiteral(ICSSParser.SizeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#colorOption}.
	 * @param ctx the parse tree
	 */
	void enterColorOption(ICSSParser.ColorOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#colorOption}.
	 * @param ctx the parse tree
	 */
	void exitColorOption(ICSSParser.ColorOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#colorLiteral}.
	 * @param ctx the parse tree
	 */
	void enterColorLiteral(ICSSParser.ColorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#colorLiteral}.
	 * @param ctx the parse tree
	 */
	void exitColorLiteral(ICSSParser.ColorLiteralContext ctx);
}