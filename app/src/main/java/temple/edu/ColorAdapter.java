package temple.edu;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
public class ColorAdapter extends BaseAdapter implements SpinnerAdapter{
    private Context ctx;
    private String [] myColor;
    String [] display;
    ColorAdapter(Context ctx, String[] myColor, String[] display ) {

        this.ctx = ctx;

        this.myColor = myColor;
        //this.collection = collection;
        this.display = display;
    }

    @Override
    public int getCount() {

        return myColor.length;
    }

    @Override
    public Object getItem(int position) {

        return myColor[position];
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = new TextView(ctx);
        //textView.setText(myColor[position]);
        textView.setText(display[position]);
        textView.setBackgroundColor(Color.parseColor(myColor[position]));  //this set the background color
        return textView;
    }
}

