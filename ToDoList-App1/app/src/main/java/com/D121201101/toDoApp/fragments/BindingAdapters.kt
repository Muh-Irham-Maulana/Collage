package com.D121201101.toDoApp.fragments

import android.view.View
import android.widget.Spinner
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.D121201101.toDoApp.R
import com.D121201101.toDoApp.data.models.Priority
import com.D121201101.toDoApp.data.models.ToDoData
import com.D121201101.toDoApp.fragments.list.ListFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BindingAdapters {

	companion object {
		@BindingAdapter("android:navigateToAddFragment")
		@JvmStatic
		fun navigateToAddFragment(view: FloatingActionButton, navigate: Boolean) {
			view.setOnClickListener {
				if (navigate) {
					view.findNavController().navigate(R.id.action_listFragment_to_addFragment)
				}
			}
		}

		@BindingAdapter("android:sendDataToUpdateFragment")
		@JvmStatic
		fun navigateToAddFragment(view: ConstraintLayout, currentItem: ToDoData) {
			view.setOnClickListener {
				val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
				view.findNavController().navigate(action)
			}
		}

		@BindingAdapter("android:emptyDatabase")
		@JvmStatic
		fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>) {
			when (emptyDatabase.value) {
				true -> view.visibility = View.VISIBLE
				false -> view.visibility = View.INVISIBLE
			}
		}

		@BindingAdapter("android:parsePriorityToInt")
		@JvmStatic
		fun parsePriorityToInt(spinner: Spinner, priority: Priority) {
			when (priority) {
				Priority.PentingMendesak -> spinner.setSelection(0)
				Priority.TidakPentingMendesak -> spinner.setSelection(1)
				Priority.PentingTidakMendesak -> spinner.setSelection(2)
				Priority.TidakPentingTidakMendesak -> spinner.setSelection(3)
			}
		}

		@BindingAdapter("android:parsePriorityColor")
		@JvmStatic
		fun parsePriorityColor(cardView: CardView, priority: Priority) {
			when (priority) {
				Priority.PentingMendesak -> cardView.setCardBackgroundColor(
					cardView.context.getColor(
						R.color.red
					)
				)
				Priority.TidakPentingMendesak -> cardView.setCardBackgroundColor(
					cardView.context.getColor(
						R.color.yellow
					)
				)
				Priority.PentingTidakMendesak -> cardView.setCardBackgroundColor(
					cardView.context.getColor(
						R.color.green
					)
				)

			}
		}
	}
}