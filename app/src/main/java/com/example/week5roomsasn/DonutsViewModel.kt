package com.example.week5roomsasn
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class DonutsViewModel(val dao:DonutDao):ViewModel() {
    var donutAmount = ""
    private val Amount: LiveData<Donut> = dao.get()

    val donutsString = Transformations.map(Amount){
        Amount->formatTasks(Amount)
    }




    fun formatTasks(donut:Donut):String{
        return donut.donutAmount.toString()
    }
    
    fun convertToString(task: LiveData<Donut>):String{
        var str = "ID: ${task.value?.donutID}"
        str += '\n'+ "Name : ${task.value?.donutAmount}"
        //str+= '\n' + "Complete : ${task.taskDone}" + '\n'
        return str
    }
    
    fun addDonuts(){
        viewModelScope.launch{
            val donut = Donut()
            donut.donutAmount = donutAmount.toInt()
            dao.insert(donut)
            //donutsString = donut.donutAmount.toString()
        }
    }
}