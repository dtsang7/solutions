  /*
	Question 2:
	decodeString(s): Given an encoded string, return its corresponding decoded string. The encoding 
	rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times. 
	Note: k is guaranteed to be a positive integer. 
	For s = "4[ab]", the output should be decodeString(s) = "abababab" 
	For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
	*/

	
	public String decodeString(String s){
		return decodeString(1, s);
	}

	public String decodeString(int k, String s){
		if(k == 0){
			return "";
		}
		
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == '['){
				int it = 0;
				int j = i - 1;
				int multiplier = 1;
				while(j >= 0 && Character.isDigit(s.charAt(j))){
					it = it + (Character.getNumericValue(s.charAt(j)) * multiplier);
					j--;
					multiplier = multiplier * 10;
				}
				return decodeString(k, s.substring(0, j+1) + decodeString(it, s.substring(i+1, s.length()-1)));
			}
		}
		return s + decodeString(k - 1, s);
	}

	/*
