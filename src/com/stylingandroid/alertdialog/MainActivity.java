package com.stylingandroid.alertdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	private static final int ALERT_DIALOG = 1;

	@Override
	public void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.main );
		
		( (Button) findViewById( R.id.button1 ) )
			.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick( View v )
				{
					showDialog( ALERT_DIALOG );
				}
			}
		);
	}

	@Override
	protected Dialog onCreateDialog( int id )
	{
		Dialog dialog = null;
		if ( id == ALERT_DIALOG )
		{
			ContextThemeWrapper ctw = new ContextThemeWrapper( this, R.style.MyTheme );
			CustomBuilder builder = new CustomBuilder( ctw );
			builder.setMessage( "Hello World" )
			    .setTitle( "Alert Dialog" )
				.setIcon( android.R.drawable.ic_dialog_alert )
				.setCancelable( false )
				.setPositiveButton( "Close",
						new DialogInterface.OnClickListener()
						{
							@Override
							public void onClick( DialogInterface dialog, int which )
							{
								dialog.dismiss();
							}
						} 
			);
			dialog = builder.create();
		}
		if ( dialog == null )
		{
			dialog = super.onCreateDialog( id );
		}
		return dialog;
	}
}