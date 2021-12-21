package telran.util;

public class Length implements Comparable<Length>{
	float amount;
	LengthUnit unit;
	Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	// V.R. This method isn't requested and isn't used
	public LengthUnit getUnit() {
		return unit;
	}
	// V.R. This method isn't requested and isn't used
	public float getAmount() {
		return amount;
	}

	@Override
	//equals two length objects according to LengthUnit (1cm = 10mm)
	public boolean equals(Object obj) {
		/* V.R. The following casting can be correctly executed fo Length only.
		 *  There isn't any protection from other cases. Somethin like following:
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
		 */
		Length lng = (Length)obj;
		/* V.R. The following conversion has to be executed for
		 *   unit !- lng.unit
		 *   
		 */
		float amountlng = lng.convert(unit).amount;
		// V.R. It turns out that 1M != 100CM. But it isn't right! 
		LengthUnit unitlng = lng.convert(unit).unit;
		return amountlng == amount && unitlng == unit ? true : false;
		// V.R. It isn't good idea to compare float values as int. I mean ==.
		// It doesn't work in many cases
		
	}
	
	@Override
	public int compareTo(Length lng) {
		// V.R. Look at my Skype message
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
