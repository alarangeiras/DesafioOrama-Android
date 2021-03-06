package br.com.allanlarangeiras.desafioorama.activities.funds.fragments.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.allanlarangeiras.desafioorama.R
import br.com.allanlarangeiras.desafioorama.activities.fundDetail.FundDetailActivity
import br.com.allanlarangeiras.desafioorama.model.dto.Fund
import br.com.allanlarangeiras.desafioorama.services.FundsService

class FundsHorizontalListRVAdapter(
    val fundsList: List<Fund>): RecyclerView.Adapter<FundsHorizontalListRVAdapter.FundsViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): FundsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_fund_horizontal_list, parent, false)

        context = parent.context

        return FundsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.fundsList.size
    }

    override fun onBindViewHolder(holder: FundsViewHolder, positon: Int) {
        val fund = fundsList[positon]
        holder.simpleName.text = fund.simpleName

        holder.card.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, FundDetailActivity::class.java)
            intent.putExtra("fund", fund)
            context.startActivity(intent)
        })
        holder.m12.text = FundsService.formatM12(fund.profitabilities.m12)
        holder.minimumApplication.text = FundsService.formatAmount(fund.operability.minimumInitialApplicationAmount)

    }

    class FundsViewHolder(
        parentView: View
    ): RecyclerView.ViewHolder(parentView) {

        val simpleName: TextView
        val m12: TextView
        val minimumApplication: TextView
        val card: CardView

        init{
            card = parentView.findViewById<CardView>(R.id.card)
            simpleName = parentView.findViewById<TextView>(R.id.simpleName)
            m12 = parentView.findViewById<TextView>(R.id.m12)
            minimumApplication = parentView.findViewById<TextView>(R.id.minimumApplication)
        }

    }

}