
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.calory_tracker.R
import com.example.calory_tracker.selectsize

class FoodItemAdapter(context: Context, resource: Int, items: List<FoodItem>) :
    ArrayAdapter<FoodItem>(context, resource, items) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.list_item_food, parent, false)
        val foodItem = getItem(position)



        val nameTextView = view.findViewById<TextView>(R.id.foodNameTextView)
        val proteinTextView = view.findViewById<TextView>(R.id.proteinTextView)
        val carbohydratesTextView = view.findViewById<TextView>(R.id.carbohydratesTextView)
        val fatTextView = view.findViewById<TextView>(R.id.fatTextView)
        val sizing = view.findViewById<TextView>(R.id.sizing)

        nameTextView.text = foodItem?.name
        proteinTextView.text = "Protein: ${foodItem?.protein} g"
        carbohydratesTextView.text = "Carbohydrates: ${foodItem?.carbohydrates} g"
        fatTextView.text = "Fat: ${foodItem?.fat} g"
        if (foodItem?.isSolid == true){
        sizing.text = "Per: 100 grams"}
        else{sizing.text = "Per: 100 mililiters"}

        view.setOnClickListener {
            val intent = Intent(context, selectsize::class.java)
            intent.putExtra("foodName", foodItem?.name)
            intent.putExtra("issolid", foodItem?.isSolid)
            intent.putExtra("protein", foodItem?.protein)
            intent.putExtra("carbs", foodItem?.carbohydrates)
            intent.putExtra("fats", foodItem?.fat)
            intent.putExtra("calories", foodItem?.calories)
            context.startActivity(intent)
        }


        return view
    }
}
