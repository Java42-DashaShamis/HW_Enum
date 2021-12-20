package telran.util;

public class Length implements Comparable<Length>{
	float amount;
	LengthUnit unit;
	Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	public LengthUnit getUnit() {
		return unit;
	}
	public float getAmount() {
		return amount;
	}

	@Override
	//equals two length objects according to LengthUnit (1cm = 10mm)
	public boolean equals(Object obj) {
		Length lng = (Length)obj;
		float amountlng = lng.convert(unit).amount;
		LengthUnit unitlng = lng.convert(unit).unit;
		return amountlng == amount && unitlng == unit ? true : false;
	}
	
	@Override
	public int compareTo(Length lng) {
		
		return 0;
	}
	
	//return new Length object with a given LengthUnit (convert(LengthUnit.M) returns Length in meters)
	public Length convert(LengthUnit unit1) {
		float amountNew = amount * unit.value / unit1.value;
		return new Length(amountNew, unit1);
	}
	
	@Override
	//returns string with amount and length unit pinned to amount with no space (20M)
	public String toString() {
		String res = amount + unit.name();
		return res;
	}

}
