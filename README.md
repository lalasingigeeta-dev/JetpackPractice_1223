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
here is the simplified look what happens internally
