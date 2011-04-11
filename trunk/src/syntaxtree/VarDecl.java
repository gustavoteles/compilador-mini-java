package syntaxtree;
import visitor.Visitor;
import visitor.TypeVisitor;

public class VarDecl {
  public Type t;
  public Identifier i;
  
  public VarDecl(Type at, Identifier ai) {
    t=at; i=ai;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public void accept(TypeVisitor v) {
    v.visit(this);
  }
}