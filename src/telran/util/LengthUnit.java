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
		
		float amountNew = l1.convert(this).amount - l2.convert(this).amount;
		return new Length (amountNew < 0 ? -amountNew : amountNew, this);
	}
}
