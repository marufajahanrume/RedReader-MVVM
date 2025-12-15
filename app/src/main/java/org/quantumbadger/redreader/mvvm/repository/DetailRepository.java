package org.quantumbadger.redreader.mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import org.quantumbadger.redreader.mvvm.R;
import org.quantumbadger.redreader.mvvm.model.DetailItem;

import java.util.ArrayList;
import java.util.List;

public class DetailRepository {
    public MutableLiveData<List<DetailItem>> getDetailsForCategory(String category) {
        MutableLiveData<List<DetailItem>> data = new MutableLiveData<>();
        List<DetailItem> list = new ArrayList<>();

        switch (category) {

            case "Trending":
                list.add(new DetailItem("AI Takes Over Mars",
                        "Scientists report early AI colonization experiments succeeding on Mars.",
                        R.drawable.pillars_of_creation, 4.8, 1892, "Oct 2025"));

                list.add(new DetailItem("Quantum Coffee",
                        "Startup brews coffee using quantum entanglement, promising infinite aroma.",
                        R.drawable.pillars_of_creation, 4.5, 1365, "Oct 2025"));

                list.add(new DetailItem("Virtual Forests Bloom",
                        "Gamers create virtual forests to combat deforestation digitally.",
                        R.drawable.pillars_of_creation, 4.6, 978, "Oct 2025"));

                list.add(new DetailItem("Ocean Robots",
                        "Autonomous drones now cleaning 45% of Pacific waste patches.",
                        R.drawable.pillars_of_creation, 4.9, 2200, "Sep 2025"));

                list.add(new DetailItem("Zero-Gravity Sports",
                        "New sport league emerges inside low-earth orbit facilities.",
                        R.drawable.pillars_of_creation, 4.7, 1055, "Sep 2025"));

                list.add(new DetailItem("Holo Pets",
                        "Virtual pets with emotional AI gain massive popularity.",
                        R.drawable.pillars_of_creation, 4.4, 600, "Aug 2025"));

                list.add(new DetailItem("Smart Forest Sensors",
                        "Forests now self-report health using satellite-linked sensors.",
                        R.drawable.pillars_of_creation, 4.8, 1143, "Aug 2025"));
                break;



            case "Favourite":
                list.add(new DetailItem("Dream Journal App",
                        "People share vivid dream logs, creating an AI map of the subconscious.",
                        R.drawable.pillars_of_creation, 4.9, 2012, "Jul 2025"));

                list.add(new DetailItem("Retro Pixel Revival",
                        "Old 8-bit games remade with neural graphics.",
                        R.drawable.pillars_of_creation, 4.7, 1783, "Jul 2025"));

                list.add(new DetailItem("Cloud City Models",
                        "Architects design real floating neighborhoods for future generations.",
                        R.drawable.pillars_of_creation, 4.8, 999, "Jun 2025"));

                list.add(new DetailItem("Cooking with AI",
                        "AI chef predicts perfect seasoning ratios for every recipe.",
                        R.drawable.pillars_of_creation, 4.6, 843, "Jun 2025"));

                list.add(new DetailItem("VR Memories",
                        "Record your life in VR to revisit later in first person.",
                        R.drawable.pillars_of_creation, 4.9, 1520, "May 2025"));
                break;



            case "All":
            default:
                list.add(new DetailItem("Community Builds Solar City",
                        "Local engineers make sustainable town completely off-grid.",
                        R.drawable.pillars_of_creation, 4.5, 654, "Apr 2025"));

                list.add(new DetailItem("AI-Powered Tutor",
                        "Students report 90% better grades after AI tutoring pilot.",
                        R.drawable.pillars_of_creation, 4.8, 876, "Mar 2025"));

                list.add(new DetailItem("Robot Farmers",
                        "Automation reaches agriculture, reducing waste dramatically.",
                        R.drawable.pillars_of_creation, 4.6, 1130, "Mar 2025"));

                list.add(new DetailItem("Music from Plants",
                        "Scientists decode bioelectric signals from flora as musical notes.",
                        R.drawable.pillars_of_creation, 4.4, 490, "Feb 2025"));

                list.add(new DetailItem("Underwater Habitats",
                        "First underwater living experiment reaches 200 days successfully.",
                        R.drawable.pillars_of_creation, 4.3, 388, "Jan 2025"));
                break;
        }


        data.setValue(list);
        return data;
    }
}
