/*
	Question 1:
	sortByStrings(s,t): Sort the letters in the string s by the order they occur in the string t. 
	You can assume t will not have repetitive characters. For s = "weather" and t = "therapyw", 
	the output should be sortByString(s, t) = "theeraw". For s = "good" and t = "odg", the output should be sortByString(s, t) = "oodg".

	Personal question:
	What if there is a letter in s but not in t? Example: s = "fellow" and t = "ewol". Where does the 'f' go?
	I will assume that whatever characters are leftover will go to the end in no particular order.
	*/
	public String sortByStrings(String s, String t){
		
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

		for(int i = 0; i < s.length(); i++){
			if(hm.containsKey(s.charAt(i))){
				hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
			}else{
				hm.put(s.charAt(i), 1);
			}
		}
	
		char[] sorted = new char[s.length()];

		int index = 0;
		for(int j = 0; j < t.length(); j++){
			if(hm.containsKey(t.charAt(j))){
				for(int k = hm.get(t.charAt(j)); k > 0; k--){
					sorted[index] = t.charAt(j);
					index++;
				}
				hm.remove(t.charAt(j));
			}
		}
		
		//insert remaining character if any
		for(Map.Entry<Character,Integer> entry: hm.entrySet()){
			for(int i = entry.getValue(); i > 0; i--){
				sorted[index] = entry.getKey();
				index++;
			}
		}

		return String.valueOf(sorted);
	}
