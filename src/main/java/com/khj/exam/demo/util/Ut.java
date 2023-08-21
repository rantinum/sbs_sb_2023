package com.khj.exam.demo.util;

public class Ut {
	public static boolean empty(Object obj) {
		if ( obj == null ) {
			return true;
		}
		
		if ( obj instanceof String == false ) {
			return true;
		}
		
		String  str = (String) obj;
		
		return str.trim().length() == 0;
	}

	public static String f(String format, Object... arges) {
		return String.format(format, arges);
	}

	public static String jsHistoryBack(String msg) {
		return Ut.f("""
				<script>
				const msg = '%s'.trim();
				
				if ( msg.length > 0 ) {
					alert(msg);	
				}
				
				history.back();				
				</script>
				""", msg);
	}

	public static String jsReplace(String msg, String uri) {
		if ( msg == null ) {
			msg = "";
		}
		
		if ( uri == null ) {
			uri = "";
		}
		
		return Ut.f("""
						<script>
						const msg = '%s'.trim();
						if ( msg.length > 0 ) {
							alert(msg);
						}
						location.replace('%s');
						</script>
						""", msg, uri);
	}

}