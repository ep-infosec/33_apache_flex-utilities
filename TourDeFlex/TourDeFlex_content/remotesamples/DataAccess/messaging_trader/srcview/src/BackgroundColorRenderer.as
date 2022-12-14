////////////////////////////////////////////////////////////////////////////////
//
//  Licensed to the Apache Software Foundation (ASF) under one or more
//  contributor license agreements.  See the NOTICE file distributed with
//  this work for additional information regarding copyright ownership.
//  The ASF licenses this file to You under the Apache License, Version 2.0
//  (the "License"); you may not use this file except in compliance with
//  the License.  You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////
package {

    import mx.controls.Label;
    import flash.display.Graphics;

	public class BackgroundColorRenderer extends Label {
		
		public static var symbol:String;

		override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
	 	{
			super.updateDisplayList(unscaledWidth, unscaledHeight);
	 		
	 		var g:Graphics = graphics;
	 		
			g.clear();

			if (data && data.date && data.symbol == symbol)
			{
				if( data.change && data.change >= 0 ) 
				{
					g.beginFill(0x009900, 0.5);
					g.drawRect(0, 0, unscaledWidth, unscaledHeight);
		 			g.endFill();
				} 
				else 
				{
					g.beginFill(0xFF0000, 0.5);
					g.drawRect(0, 0, unscaledWidth, unscaledHeight);
		 			g.endFill();
				}
			}

		}
  	}

}