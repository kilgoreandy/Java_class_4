/* 
 * Copyright (c) 2021. 
 * Educational Community License, Version 2.0 (the "License"); you may 
 * not use this file except in compliance with the License. You may 
 * obtain a copy of the License at 
 * 
 * http://www.osedu.org/licenses/ECL-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" 
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express 
 * or implied. See the License for the specific language governing 
 * permissions and limitations under the License. 
 */

package com.makesrc;

import java.io.File;
import java.util.List;

public class KentMain {
  public static void main(String[] args) {
    //
    try {
      FileDayTimer fileDayTimer = new FileDayTimer(new File("fileDayTimerData.bin"));
      assert (fileDayTimer.size() == 0);
      Contact contact1 = new Contact("aaa", "aaa", "aaa@aaa.com", "1111111");
      fileDayTimer.add(contact1);
      Contact c = fileDayTimer.findByEmail("aaa@aaa.com");
      assert (c.equals(contact1));
      fileDayTimer.add(new Contact("zzz", "zzz", "zzz@zzz.com", "6666666"));
      fileDayTimer.add(new Contact("ddd", "ddd", "ddd@ddd.com", "4444444"));
      assert (fileDayTimer.size() == 3);
      List<Contact> contactList = fileDayTimer.getAll();
      System.out.printf("List of all contacts: (%d):  %s\n", contactList.size(), contactList);
      fileDayTimer.close();

      // reopen the file
      fileDayTimer = new FileDayTimer(new File("fileDayTimerData.bin"));
      // add some more
      Contact contact4 = new Contact("ccc", "ccc", "ccc@ccc.com", "3333333");
      fileDayTimer.add(contact4);
      fileDayTimer.add(new Contact("bbb", "bbb", "bbb@bbb.com", "2222222"));
      fileDayTimer.add(new Contact("yyy", "yyy", "yyy@yyy.com", "5555555"));
      assert (fileDayTimer.size() == 6);
      c = fileDayTimer.findByEmail("ccc@ccc.com");
      assert (c.equals(contact4));
      contactList = fileDayTimer.getAll();
      System.out.printf("List of all contacts: (%d):  %s\n", contactList.size(), contactList);
      fileDayTimer.close();

      // reopen the file
      fileDayTimer = new FileDayTimer(new File("fileDayTimerData.bin"));
      // add some more
      fileDayTimer.remove("aaa@aaa.com");
      fileDayTimer.remove("bbb@bbb.com");
      fileDayTimer.remove("ccc@ccc.com");
      assert (fileDayTimer.size() == 3);
      contactList = fileDayTimer.getAll();
      System.out.printf("List of all contacts: (%d):  %s\n", contactList.size(), contactList);
      fileDayTimer.close();

    } catch (Exception e) {
      System.err.println("Failed to process data file.");
    }
  }
}
