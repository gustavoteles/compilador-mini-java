package syntaxtree;
import visitor.TranslateVisitor;
import visitor.Visitor;
import visitor.TypeVisitor;

public abstract class Exp {
  public int beginLine;
  
public abstract void accept(Visitor v);
  public abstract Type accept(TypeVisitor v);
  public abstract translate.Exp accept(TranslateVisitor v);//Translate.java
}