package kannpuro.main;
import java.beans.JavaBean;
import java.util.Objects;

@JavaBean
class Var {
	@Override
	public String toString() {
		return value.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Var other = (Var) obj;
		return Objects.equals(value, other.value);
	}

	private Object value;
	public Var() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Var(Object v){
		value = v;
	}
	Object getValue() {
		return value;
	}
	void setValue(Object value) {
		this.value = value;
	}
}	
