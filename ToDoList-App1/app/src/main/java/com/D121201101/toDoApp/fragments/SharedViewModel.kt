package com.D121201101.toDoApp.fragments

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.D121201101.toDoApp.R
import com.D121201101.toDoApp.data.models.Priority
import com.D121201101.toDoApp.data.models.ToDoData

class SharedViewModel(application: Application): AndroidViewModel(application) {

	val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

	fun isDatabaseEmpty(toDoData: List<ToDoData>) {
		emptyDatabase.value = toDoData.isEmpty()
	}

	val listener: AdapterView.OnItemSelectedListener = object:
		AdapterView.OnItemSelectedListener {
			override fun onItemSelected(
				parent: AdapterView<*>?,
				view: View?,
				position: Int,
				id: Long
			) {
				when(position) {
					0 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.red))}
					1 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application,
						android.R.color.holo_orange_dark
					))}
					2 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application,
						R.color.yellow
					))}
					3 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application,
						R.color.green
					))}
				}
			}

			override fun onNothingSelected(
				parent: AdapterView<*>?
			) {

			}
		}

	fun verifyDataFromUser(title: String, desc: String): Boolean {
		return !(title.isNullOrEmpty() || desc.isNullOrEmpty())
	}

	fun parsePriorityString(priority: String): Priority {
		return when(priority) {
			"Penting Mendesak" -> Priority.PentingMendesak
			"Tidak Penting Mendesak" -> Priority.TidakPentingMendesak
			"Penting Tidak Mendesak" -> Priority.PentingTidakMendesak
			"Tidak Penting Tidak Mendesak" -> Priority.TidakPentingTidakMendesak
			else -> Priority.TidakPentingTidakMendesak
		}
	}
}