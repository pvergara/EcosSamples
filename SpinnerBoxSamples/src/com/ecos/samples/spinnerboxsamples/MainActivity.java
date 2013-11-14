package com.ecos.samples.spinnerboxsamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ecos.samples.spinnerboxsamples.model.SomePojo;

public class MainActivity extends RoboActivity {

	private List<SomePojo> mPojoCollection;

	@InjectView(R.id.myFirstSpinner)Spinner mMyFirstSpinner;
	@InjectView(R.id.txtItem)TextView mSelectedPojoDescription;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		mPojoCollection = getCollection();
		ArrayAdapter<SomePojo> adapter = new ArrayAdapter<SomePojo>(this,R.layout.item_spinner_text,R.id.txtItem,mPojoCollection);
		
		mMyFirstSpinner.setOnItemSelectedListener(mMyFirstSpinnerOnSelected);
		
		mMyFirstSpinner.setAdapter(adapter);
		
		mMyFirstSpinner.setSelection(3, true);
		
		
    }


	private List<SomePojo> getCollection() {
		List<SomePojo> pojos = 
			new ArrayList<SomePojo>(
				Arrays.asList(new SomePojo[]{
					new SomePojo(1,"lerele"),
					new SomePojo(2,"Lolailo"),
					new SomePojo(3,"tikotiko"),
					new SomePojo(4,"ñakañaka")})
			);
		return pojos;
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //Event
	private OnItemSelectedListener mMyFirstSpinnerOnSelected = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long arg3) {
			SomePojo selectedItem = mPojoCollection.get(position);
			
			mSelectedPojoDescription.setText(selectedItem.getName());
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	}; 

    
}
