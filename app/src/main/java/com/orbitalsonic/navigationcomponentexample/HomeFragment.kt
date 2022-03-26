package com.orbitalsonic.navigationcomponentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        view.findViewById<Button>(R.id.btn_send_money).setOnClickListener {
            // Navigate By Safe Arg
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }

        view.findViewById<Button>(R.id.btn_view_balance).setOnClickListener {
            // Navigate By Safe Arg
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            navController.navigate(action)

            // Navigate By ID
//            navController.navigate(R.id.viewBalanceFragment)

            // Navigate By ID and animation
//            val navOption = NavOptions.Builder()
//                .setEnterAnim(R.anim.slide_in_right)
//                .setEnterAnim(R.anim.slide_out_left)
//                .setPopEnterAnim(R.anim.slide_in_left)
//                .setPopExitAnim(R.anim.slide_out_right).build()
//
//            navController.navigate(R.id.viewBalanceFragment,null, navOption)
        }

        view.findViewById<Button>(R.id.btn_transaction).setOnClickListener {
            // Navigate By Safe Arg
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment()
            navController.navigate(action)

            // Navigate By Action
//            navController.navigate(R.id.action_homeFragment_to_viewTransactionFragment)


        }

    }

}