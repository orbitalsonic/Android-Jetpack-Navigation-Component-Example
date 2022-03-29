package com.orbitalsonic.navigationcomponentexample

import android.app.PendingIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class ChooseReceiverFragment : Fragment() {

    private lateinit var etReceiverName: EditText

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

//            val pendingIntent = NavDeepLinkBuilder(requireContext())
//                .setGraph(R.navigation.main_nav_graph)
//                .setDestination(R.id.sendCashFragment)
//                .setArguments(SendCashFragmentArgs("Yaqoob Bhatti",786L).toBundle())
//                .createPendingIntent()

            val pendingIntent = findNavController()
                .createDeepLink()
                .setGraph(R.navigation.main_nav_graph)
                .setDestination(R.id.sendCashFragment)
                .setArguments(SendCashFragmentArgs(receiverName, 786L).toBundle())
                .createPendingIntent()

            showNotification(pendingIntent, receiverName)

            val action =
                ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(
                    receiverName,
                    300
                )
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

    private fun showNotification(pendingIntent: PendingIntent, receiverName: String) {
        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("Complete Transaction")
            .setContentText("Send money to $receiverName")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(requireContext()).notify(1002, notification)
    }
}