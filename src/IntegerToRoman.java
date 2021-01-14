public class IntegerToRoman {
	public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int reminder = num;        
        int thousands = reminder/1000;
        reminder = reminder%1000;
        addThousands(result, thousands);
        
        int hundreds = reminder/100;
        reminder = reminder%100;
        addHundreds(result, hundreds);

        int tens = reminder/10;
        reminder = reminder%10;
        addTens(result, tens);

        int ones = reminder;
        addOnes(result, ones);
        return result.toString();
    }
	
	private void addThousands(StringBuilder result, int thousands) {
		while (thousands > 0) {
            result.append('M');
            thousands--;
        }
	}
	
	private void addHundreds(StringBuilder result, int hundreds) {
		while (hundreds > 0) {
            switch(hundreds) {
            case 9:
                hundreds = 0;   
                result.append("CM");
                break;
            case 8, 7, 6, 5:
                hundreds = hundreds - 5;   
                result.append("D");
                break;  
            case 4:
                hundreds = 0;
                result.append("CD");
                break;
            default:
                hundreds--;
                result.append("C");
                break;
            }
        }
	}
	
	private void addTens(StringBuilder result, int tens) {
		while (tens > 0) {
            switch(tens) {
            case 9:
                tens = 0;   
                result.append("XC");
                break;
            case 8, 7, 6, 5:
                tens = tens - 5;
                result.append("L");
                break;
            case 4:
                tens = 0;
                result.append("XL");
                break;
            default:
                tens--;
                result.append("X");
                break;
            }
        }
	}

	private void addOnes(StringBuilder result, int ones) {
		while (ones > 0) {
            switch(ones) {
            case 9:
                ones = 0;   
                result.append("IX");
                break;
            case 8, 7, 6, 5:
                ones = ones - 5;
                result.append("V");
                break;
            case 4:
                ones = 0;
                result.append("IV");
                break;
            default:
                ones--;
                result.append("I");
                break;
            }
        }
	}
}
