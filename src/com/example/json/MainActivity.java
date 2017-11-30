package com.example.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;

import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView output=(TextView)findViewById(R.id.textView1);
        String strJson="{\" Employee\""+":[{\"id\":\"101\",\"name\":\"Pankaj\",\"salary\":\"500\"},"
        + "{\"id\":\"102\"\"name\":\"Lalit\",\"salary\":\"6000\"}]}";
        String data = "";
        try
        {
        	//Create the root JSONObject from the JSON string;
        	JSONObject jsonRootObject = new JSONObject(strJson);
        	//Get the instance of JSONArray that contains JSONObjects
        	JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");
        	//Iterate the jsonArray and print the info of JSONObjects
        	for (int i = 0;i<jsonArray.length();i++)
        	{
        		JSONObject jsonObject = jsonArray.getJSONObject(i);
        		int id = Integer.parseInt(jsonObject.optString("id").toString());
        		String name = jsonObject.optString("name").toString();
        		float salary =Float.parseFloat(jsonObject.optString("salary").toString());
        		data+= "Node"+i+":\n id=" +id+"\n Name = "+name+"\n Salary="+salary+"\n";
        		
        		
        	}
        	output.setText(data);
        } catch(JSONException e)
        {
        	e.printStackTrace();
    }}    
    


    
    
}
