package telran.util;

public enum LengthUnit {
	MM(1f), CM(10f), INCH(25.4f), FOOT(304.8f), M(1000f), KM(1000000f);
	float value;
	private LengthUnit(float value){
		this.value = value;
	}
	
	public float getValue() {
		return value;
	}
	
	//Length object with amount of the LengthUnit (LengthUnit.M.between(new Length(200f, LengthUnit.CM), new Length(1f, LengthUnit.M)) => Length(1f, LengthUnit.M))
	public Length between(Length l1, Length l2) {
		float amountl1 = l1.amount * l1.unit.value / value;
		float amountl2 = l2.amount * l2.unit.value / value;
		float amountNew = amountl1-amountl2;
		// V.R. It isn't necessary to write special method getLengthUnitFromValue
		// It is this here!
		return new Length (amountNew < 0 ? -amountNew : amountNew, getLengthUnitFromValue(value));
	}
	
	private LengthUnit getLengthUnitFromValue(float value) {
		for(LengthUnit unit: LengthUnit.values()) {
			if(unit.getValue() == value) {
				return unit;
			}
		}
		return null;
	}
}
