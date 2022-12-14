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
package classes
{
	import mx.collections.ArrayCollection;
	
	public final class ObjectListSortTypes
	{
		
		public static const ALPHABETICAL:String = "Alphabetical";
		public static const MOST_RECENT:String = "Most Recent";
		public static const MOST_POPULAR:String = "Most Popular";	
		
		[Bindable]
		public static var ObjectListSortTypeArray:Array = [ALPHABETICAL, MOST_RECENT, MOST_POPULAR];
		
		public function ObjectListSortTypes()
		{
		}		

	}
}