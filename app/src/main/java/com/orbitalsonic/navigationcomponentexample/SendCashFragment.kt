package com.orbitalsonic.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class SendCashFragment : Fragment() {

    private lateinit var tvReceiver:TextView
    private lateinit var etAmount:EditText

    private val args:SendCashFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_cash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvReceiver = view.findViewById(R.id.tv_receiver)
        etAmount = view.findViewById(R.id.et_amount)
        etAmount.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner){
            etAmount.setText(it.toString())
        }

        // get args using safe args
        val receiverName = args.receiverName
        val amount = args.amount
        tvReceiver.text = "Send cash to $receiverName"
        etAmount.setText(amount.toString())

        // get args using bundle
//        val receiverName = arguments?.getString("name")
//        tvReceiver.text = "Send cash to $receiverName"

        view.findViewById<Button>(R.id.btn_send).setOnClickListener {

            if (etAmount.text.toString().isEmpty())
                return@setOnClickListener

            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(receiverName,etAmount.text.toString().toLong())
            findNavController().navigate(action)
        }

        view.findViewById<Button>(R.id.btn_done).setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,true)
        }

    }
}