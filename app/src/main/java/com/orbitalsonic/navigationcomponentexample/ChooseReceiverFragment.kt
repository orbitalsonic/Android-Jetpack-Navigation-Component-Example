package com.orbitalsonic.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController


class ChooseReceiverFragment : Fragment() {

    private lateinit var etReceiverName:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etReceiverName = view.findViewById(R.id.et_receiver_name)

        view.findViewById<Button>(R.id.btn_next).setOnClickListener {

            val receiverName = etReceiverName.text.toString()

            val action = ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(receiverName,300)
            findNavController().navigate(action)

         //   send data using bundle
//            val navOption = NavOptions.Builder()
//                .setEnterAnim(R.anim.slide_in_right)
//                .setEnterAnim(R.anim.slide_out_left)
//                .setPopEnterAnim(R.anim.slide_in_left)
//                .setPopExitAnim(R.anim.slide_out_right).build()
//
//            val receiverName = etReceiverName.text.toString()
//
//            val args = Bundle()
//            args.putString("name",receiverName)
//
//            findNavController().navigate(R.id.sendCashFragment,args, navOption)
        }

        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            findNavController().popBackStack()
        }
    }
}