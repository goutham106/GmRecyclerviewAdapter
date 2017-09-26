# GmRecyclerviewAdapter

Powerful and flexible RecyclerAdapter, Through this we can minimise code a lot, Please feel free to use this.


### proguard-rules.pro

~~~
-keep class com.gm.base.** {
*;
}
-keep public class * extends com.gm.base.adapter.BaseQuickAdapter
-keep public class * extends com.gm.base.adapter.BaseViewHolder
-keepclassmembers public class * extends com.gm.base.adapter.BaseViewHolder {
     <init>(android.view.View);
}

~~~


### License

~~~~
Copyright (C) 2017. Gowtham Parimelazhagan.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0
       
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
~~~~
