/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adobe.ac.ncss.filters;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

/**
 * @author xagnetti
 */
public class FlexFilter implements FilenameFilter
{
   /*
    * (non-Javadoc)
    * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
    */
   public boolean accept( final File dir,
                          final String name )
   {
      boolean accepted = false;

      if ( !new File( dir, name ).isDirectory() )
      {
         accepted = name.toLowerCase( Locale.US ).endsWith( ".as" )
               || name.toLowerCase( Locale.US ).endsWith( ".mxml" );
      }
      return accepted;
   }
}
