This App mainly built to understand how viewmodel will survive configuration changes.
ViewModel is jetpack architetural lifecycle aware component whose job is to store and manage ui related data in such way that survive configuration changes like screen rotation
*********************************************************************************************************************************************************************************
********why we use viewmodel**********
Rotating phone without using view model will destroy and recreates Activity
Any data in local variable will get lost if haven't store and retrive it manually

*********************Instatiation ***************************
val viemodel=ViewModelProvider(this)[ViewModel::class.java]
                        OR
val viewmodel=ViewModel by viewmodels() 
why can't instatiate viewmodel in the normal way like
val viewmodel=ViewModel()
if instatantiate in this way for every screen rotation activity will recreate and new instance of viewmodel will aslo create so it will not survive screen rotation.

***************************************How viewModel works internally*****************************************
Think of viewmodel as seperate container object.
when you write 
val myViewModel: MyViewModel by viewModels()
Behind the scenes Android uses 
1.ViewModelProvider
2.ViewModelStoreOwner
3.ViewModelStore

************************Creation Flow*************************
Lets go step by step
Step A – Activity as ViewModelStoreOwner
  Every Activity and fragment implements viewmodelstoreOwner 
  that means they own an object called 
  "viewmodelstore"
  This store is like Map
  Key->viewmodel instance

Step B – You request a ViewModel
    When the Activity starts and you ask for viewmodel using viewmodels() like 
    val viewmodel =ViewModel by viewModels()
    Internally Android does this
    ViewModelProvider(activity).get(ViewModel::class.java)
    
Step C- ViewModelProvider checks ViewModelStore 
    ViewmodelProvider first checks
    is there already viewmodel object is already available in the store
    if YES->returns the existing instance
    if NO->create new instance using Factory
    
    **********************************************************Why ViewModel survive Rotation*********************************
    Here is the magic
    When the Configuration change happens 
    1.Activity is destroyed
    2.But system stores viewmodelstore in memory
    3.New Activity get attaches to the same store
   old Activity}->>>>
                               ViewModelStore----->ViewModel
   new Activity }->>>
