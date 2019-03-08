package temple.edu;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


public class CanvasFragment extends Fragment{

    String[] myColorArray;
    int postion;
    static final String myColor = "myColors";
    static final String Position = "atPosition";

    public CanvasFragment(){  //empty constructor

    }
    public static CanvasFragment newInstance(String[] andColors, int postion){
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putStringArray(myColor, andColors);
        args.putInt(Position, postion);
        fragment.setArguments(args);
        return fragment;


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            myColorArray = getArguments().getStringArray(myColor);
            postion = getArguments().getInt(Position);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canvas, container, false);

       // FrameLayout frameLayout = view.findViewById(R.id.canvas_background);
        FrameLayout frameLayout = view.findViewById(R.id.frag);
        frameLayout.setBackgroundColor(Color.parseColor(myColorArray[this.postion]));
        return view;
    }
    public void onColorSelected(int position){
        this.postion = position;
        updateBackgroudColor();
    }


    //at the this postion cahnge the beckground color
    private void updateBackgroudColor(){
        FrameLayout frameLayout = getView().findViewById(R.id.canvasBack);
        frameLayout.setBackgroundColor(Color.parseColor(myColorArray[this.postion]));
    }



}
