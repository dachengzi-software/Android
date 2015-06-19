package com.ftfl.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class DynamicMove extends View {
	public int xMin = 0; // This view's bounds
	public int xMax;
	public int yMin = 0;
	public int yMax;
	public float ballRadius = 60; // Ball's radius

	public RectF ballBounds1; // Needed for Canvas.drawOval
	public float ballX1 = ballRadius + 10; // Ball's center (x,y)
	public float ballY1 = ballRadius + 30;
	public float ballSpeedX1 = 15; // Ball's speed (x,y)
	public float ballSpeedY1 = 10;

	private RectF ballBounds2;
	private float ballX2 = ballRadius + 300; // Ball's center (x,y)
	private float ballY2 = ballRadius + 100;
	private float ballSpeedX2 = 15; // Ball's speed (x,y)
	private float ballSpeedY2 = 10;

	private Paint paint; // The paint (e.g. style, color) used for drawing
	
	// Constructor
	public DynamicMove(Context context) {
		super(context);

		ballBounds1 = new RectF();//set ontouch method for this ball
		ballBounds2 = new RectF();
		paint = new Paint();
	}

	// Called back to draw the view. Also called by invalidate().
	@Override
	protected void onDraw(Canvas canvas) {
		// Draw the ball
		// left = ballX - ballRadius
		// top = ballY - ballRadius
		// right = ballX + ballRadius
		// bottom = ballY + ballRadius
		ballBounds1.set(ballX1 - ballRadius, ballY1 - ballRadius, ballX1
				+ ballRadius, ballY1 + ballRadius);
		paint.setColor(Color.RED);
		canvas.drawOval(ballBounds1, paint);

		// 2nd ball
		ballBounds2.set(ballX2 - ballRadius, ballY2 - ballRadius, ballX2
				+ ballRadius, ballY2 + ballRadius);
		paint.setColor(Color.BLUE);
		canvas.drawOval(ballBounds2, paint);

		// Update the position of the ball, including collision detection and
		// reaction.
		update();

		// Delay
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
		}

		invalidate(); // Force a re-draw
	}

	// Detect collision and update the position of the ball.
	private void update() {
		// Get new (x,y) position
//		ballX1 += ballSpeedX1;
//		ballY1 += ballSpeedY1;

		ballX2 += ballSpeedX2;
		ballY2 += ballSpeedY2;

	
		// left = ballX - ballRadius
		// top = ballY - ballRadius
		// right = ballX + ballRadius
		// bottom = ballY + ballRadius
		// Detect collision and react
		if (ballX1 + ballRadius > xMax) {
			ballSpeedX1 = -ballSpeedX1;
			ballX1 = xMax - ballRadius;
		} else if (ballX1 - ballRadius < xMin) {
			ballSpeedX1 = -ballSpeedX1;
			ballX1 = xMin + ballRadius;
		}
		if (ballY1 + ballRadius > yMax) {
			ballSpeedY1 = -ballSpeedY1;
			ballY1 = yMax - ballRadius;
		} else if (ballY1 - ballRadius < yMin) {
			ballSpeedY1 = -ballSpeedY1;
			ballY1 = yMin + ballRadius;
		}

		// 2nd ball
		// Detect collision and react
		if (ballX2 + ballRadius > xMax) {
			ballSpeedX2 = -ballSpeedX2;
			ballX2 = xMax - ballRadius;
		} else if (ballX2 - ballRadius < xMin) {
			ballSpeedX2 = -ballSpeedX2;
			ballX2 = xMin + ballRadius;
		}
		if (ballY2 + ballRadius > yMax) {
			ballSpeedY2 = -ballSpeedY2;
			ballY2 = yMax - ballRadius;
		} else if (ballY2 - ballRadius < yMin) {
			ballSpeedY2 = -ballSpeedY2;
			ballY2 = yMin + ballRadius;
		}

		//measure distance for collision
		float dy12 = ballY1 - ballY2;
		float dx12 = ballX1 - ballX2;
		float distance12 = dy12 * dy12 + dx12 * dx12;

		if (distance12 < ((2 * ballRadius) * (2 * ballRadius))) {
			ballSpeedX1 = -ballSpeedX1;
			ballSpeedY1 = -ballSpeedY1;
			ballSpeedX2 = -ballSpeedX2;
			ballSpeedY2 = -ballSpeedY2;
		}
	}

	// Called back when the view is first created or its size changes.
	@Override
	public void onSizeChanged(int w, int h, int oldW, int oldH) {
		// Set the movement bounds for the ball
		xMax = w - 1;
		yMax = h - 1;
	}
	
	   public boolean onTouchEvent(MotionEvent event) {
		   
			float x =  event.getRawX();
			float y =  event.getRawY();

			switch(event.getAction() & MotionEvent.ACTION_MASK){
			case MotionEvent.ACTION_DOWN:
			
				ballX1 = x; 
				ballY1 = y-200; 
				//invalidate();
				break;
				
			case MotionEvent.ACTION_UP:
				
				
				break;
				
			case MotionEvent.ACTION_MOVE:
				ballX1 = x; 
				ballY1 = y-200; 
				invalidate();
				
				break;
			}
	   
	        return true;
	    }
}
