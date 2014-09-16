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


public class PasswdEntry {

   public String Username;
   public String Password;
   public int UserID;
   public int GroupID;
   public String UserIDInfo;
   public String HomeDirectory;
   public String Shell;

   public boolean isDefined;

   public PasswdEntry() {
      this.Username = null;
      this.Password = "x";
      this.UserID = 0;
      this.GroupID = 0;
      this.UserIDInfo = "";
      this.HomeDirectory = "";
      this.Shell = "/sbin/nologin";

      this.isDefined = false;
   }

   public PasswdEntry(String Entry) {
      this.SetFromString(Entry);
   }
   
   public String GetFormattedEntry() {
      String Result = null;

      if (this.isDefined) {
         Result = this.Username + ":" + this.Password + ":" + this.UserID + ":"
               + this.GroupID + ":" + this.UserIDInfo + ":"
               + this.HomeDirectory + ":" + this.Shell;
      }

      return Result;
   }

   public void SetFromString(String Entry) {
      // split will delimit all fields, even if empty.
      // Numbers for user id / group id must be present however
      String[] Elements = Entry.split(":");

      this.Username = Elements[0];
      this.Password = Elements[1];
      this.UserID = Integer.parseInt(Elements[2]);
      this.GroupID = Integer.parseInt(Elements[3]);
      this.UserIDInfo = Elements[4];
      this.HomeDirectory = Elements[5];
      this.Shell = Elements[6];

      this.isDefined = true;      
   }
}
