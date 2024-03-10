grammar Configuration;

// This puts a package statement at the top of the output Java files.
@header {
package intexpr.parser;
// Do not edit this .java file! Edit the grammar in IntegerExpression.g4 and re-run Antlr.
}

// This adds code to the generated parser.
@members {
    // This method makes the lexer or parser stop running if it encounters
    // invalid input and throw a ParseCancellationException.
    public void reportErrorsAsExceptions() {
        // To prevent any reports to standard error, add this line:
        //removeErrorListeners();
        
        addErrorListener(new BaseErrorListener() {
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol, 
                                    int line, int charPositionInLine,
                                    String msg, RecognitionException e) {
                throw new ParseCancellationException(msg, e);
            }
        });
    }
}
