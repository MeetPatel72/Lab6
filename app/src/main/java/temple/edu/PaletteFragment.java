package temple.edu;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

public class PaletteFragment extends Fragment{
  static String myColor = "androidColors";
  static String myColorNames = "colorNames";
  String[] myColorsArray;
  String[] colorNameArray;
  OnColorSelectedListener mCallback;
  public PaletteFragment(){
      //empty constructor
  }
  public static PaletteFragment newInstance(String[] andColors, String[] colorNames){
      PaletteFragment fragment = new PaletteFragment(); //make instance of it
      Bundle args = new Bundle();

      args.putStringArray(myColor, andColors);  //put the arrays in bundle
      args.putStringArray(myColorNames, colorNames);

      fragment.setArguments(args);
      return fragment;
  }
  @Override
    public void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      if(getArguments() != null){
          myColorsArray = getArguments().getStringArray(myColor);
          colorNameArray = getArguments().getStringArray(myColorNames);
      }

  }



  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.fragment_palette, container, false);
      GridView gdView = (GridView) v.findViewById(R.id.colorGrid);
     //Spinner spinner;   //creating a spinner object
     // spinner = (Spinner)v.findViewById(R.id.spinner);

      gdView.setAdapter(new ColorAdapter(getActivity(), myColorsArray, colorNameArray));

      gdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                /* Here we'll send a message back to our parent Activity using the callback defined
                in our interface. All we'll send is the position of the color they clicked.*/
              mCallback.onColorSelected(position);
          }
      });

      //spinner.setAdapter(new ColorAdapter(getActivity(), andColors, colorNames));

      //spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       //   @Override
        //  public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                /* Here we'll send a message back to our parent Activity using the callback defined
                in our interface. All we'll send is the position of the color they clicked.*/
            //  mCallback.onColorSelected(position);
         // }
      //});


      return v;
  }
  public interface OnColorSelectedListener{
      void onColorSelected(int position);

  }
  public void onAttach(Context context){
      super.onAttach(context);
      try{
          mCallback = (OnColorSelectedListener) context;

      }catch (ClassCastException e){
          throw new ClassCastException(context.toString() + "implement onColorSelectedListner");
      }

  }
}
