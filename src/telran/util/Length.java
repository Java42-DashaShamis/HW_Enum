package telran.util;

public class Length implements Comparable<Length>{
	float amount;
	LengthUnit unit;
	
	private float THRESHOLD = 0.0001f;
	
	Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}


	@Override
	//equals two length objects according to LengthUnit (1cm = 10mm)
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Length lng = (Length)obj;
		if(unit != lng.unit) {
			lng = lng.convert(unit);
		}
		return Math.abs(amount - lng.amount) < THRESHOLD ? true : false;
	}
	
	@Override
	public int compareTo(Length lng) {
		if(this == lng) {
			return 0;
		}
		Length lngNew = unit != lng.unit? lng.convert(unit) : lng;
		float amountlng = lngNew.convert(unit).amount;
		return Math.abs(amount - amountlng) < THRESHOLD ? 0 : Float.compare(amount, amountlng);
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
