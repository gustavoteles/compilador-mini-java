package syntaxtree;
import visitor.TranslateVisitor;
import visitor.Visitor;
import visitor.TypeVisitor;

public abstract class Exp {
  public int line;
  
public abstract void accept(Visitor v);
  public abstract Type accept(TypeVisitor v);
  public abstract activationRegister.util.Exp accept(TranslateVisitor v);//Translate.java
}