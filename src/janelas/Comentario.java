package janelas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Comentario {
	private String autor;
	private String comentario;
	private String dataPost;
	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getDataPost() {
		return dataPost;
	}
	public void setDataPost() {
		long agora = System.currentTimeMillis();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(agora);

		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
		int mHour = calendar.get(Calendar.HOUR_OF_DAY);
		int mMinu = calendar.get(Calendar.MINUTE);
		String x= mDay+"/"+mMonth+"/"+mYear+" "+mHour+":"+mMinu;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date nova;
		try {
			nova = sdf.parse(x);
			this.dataPost = nova+"";
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}