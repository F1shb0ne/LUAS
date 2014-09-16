/*
Copyright (c) 2014 F1shb0ne f1shb0nes80@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package ca.vire.LUAS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
 * This class will represent a passwd file object, the default constructor takes the path
 * to the file on the file system.
 */

public class Passwd {

   public int NumEntries;
   public boolean isDefined;
   
   // Contains all the elements in a passwd file
   private List<PasswdEntry> Entries = new ArrayList<PasswdEntry>();
   
   public Passwd() {
      NumEntries = 0;
      isDefined = false;
   }
   
   public Passwd(String FilePath) {
      BufferedReader reader;
      String line;
      int LineNumber = 0;

      try {
         reader = new BufferedReader(new FileReader(FilePath));
         try {
            while ((line = reader.readLine()) != null) {
               if (line.length() > 6) {
                  ++LineNumber;
                  Entries.add(new PasswdEntry(line));
               }
            }
            this.NumEntries = LineNumber;
            Util.InfoMsg("Loaded " + this.NumEntries + " entries.");            
            this.isDefined = true;
            reader.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      } catch (FileNotFoundException e) {
         Util.ErrorMsg("Could not open \"" + FilePath + "\" for reading.");
         e.printStackTrace();
      }
   }
}
