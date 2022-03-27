package com.orbitalsonic.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ConfirmDialogFragment : BottomSheetDialogFragment() {

    val args:SendCashFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverName = args.receiverName
        val amount = args.amount

        view.findViewById<TextView>(R.id.tv_message).text = "Do you want to send Rs$amount to $receiverName?"
        view.findViewById<Button>(R.id.btn_yes).setOnClickListener {
            Toast.makeText(requireContext(),"$amount has been sent to $receiverName",Toast.LENGTH_SHORT).show()
            dismiss()
        }
        view.findViewById<Button>(R.id.btn_no).setOnClickListener {
            dismiss()
        }

    }
}