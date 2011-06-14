package treeIR;

import activationRegister.temp.Label;

public class CJUMP extends Stm {
	

	public int relop;

	public Exp left, right;

	public Label iftrue, iffalse;

	public CJUMP(int rel, Exp l, Exp r, Label t, Label f) {
		relop=rel; 
		left=l; 
		right=r; 
		iftrue=t; 
		iffalse=f;
	}

	public final static int EQ=0, NE=1, LT=2, GT=3, LE=4, GE=5,ULT=6, ULE=7, UGT=8, UGE=9;

	@Override
	public ExpList kids(){
		return new ExpList(left, new ExpList(right,null));
	}

	@Override
	public Stm build(ExpList kids) {
	    return new CJUMP(relop,kids.head,kids.tail.head,iftrue,iffalse);
	}

	public static int notRel(int relop) {
	    switch (relop) {
	        case EQ:  return NE;
	        case NE:  return EQ;
	        case LT:  return GE;
	        case GE:  return LT;
	        case GT:  return LE;
	        case LE:  return GT;
	        case ULT: return UGE;
	        case UGE: return ULT;
	        case UGT: return ULE;
	        case ULE: return UGT;
	        default: throw new Error("bad relop in CJUMP.notRel");
	    }
	  }
	
	@Override
	public String print() {
		String str = "CJUMP("+ left.print();
	    switch (relop) {
		    case EQ:  str += " = ";
		    	break;
		    case NE:  str += " != ";
		    	break;
		    case LT:  str += " < ";
		    	break;
		    case GE:  str += " >= ";
		    	break;
		    case GT:  str += " > ";
		    	break;
		    case LE:  str += " <= ";
		    	break;
		    case ULT: str += " !< ";
		    	break;
		    case UGE: str += " !>= ";
		    	break;
		    case UGT: str += " !> ";
		    	break;
		    case ULE: str += " !<= ";
		    	break;
		 }
	    str += right.print()+" , "+iftrue.print()+" , "+iffalse.print()+" );";
		return str;
	}
}

