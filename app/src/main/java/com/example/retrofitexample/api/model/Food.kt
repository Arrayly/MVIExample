package com.example.retrofitexample.api.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Food(

    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("from")
    @Expose
    val from: Int,
    @SerializedName("hits")
    @Expose
    val hits: List<Hit>,
    @SerializedName("more")
    @Expose
    val more: Boolean,
    @SerializedName("q")
    @Expose
    val q: String,
    @SerializedName("to")
    @Expose
    val to: Int
) : Serializable {
    data class Hit(
        @SerializedName("bookmarked")
        val bookmarked: Boolean,
        @SerializedName("bought")
        val bought: Boolean,
        @SerializedName("recipe")
        val recipe: Recipe
    ) {
        data class Recipe(
            @SerializedName("calories")
            val calories: Double,
            @SerializedName("cautions")
            val cautions: List<String>,
            @SerializedName("dietLabels")
            val dietLabels: List<Any>,
            @SerializedName("digest")
            val digest: List<Digest>,
            @SerializedName("healthLabels")
            val healthLabels: List<String>,
            @SerializedName("image")
            val image: String,
            @SerializedName("ingredientLines")
            val ingredientLines: List<String>,
            @SerializedName("ingredients")
            val ingredients: List<Ingredient>,
            @SerializedName("label")
            val label: String,
            @SerializedName("shareAs")
            val shareAs: String,
            @SerializedName("source")
            val source: String,
            @SerializedName("totalDaily")
            val totalDaily: TotalDaily,
            @SerializedName("totalNutrients")
            val totalNutrients: TotalNutrients,
            @SerializedName("totalTime")
            val totalTime: Double,
            @SerializedName("totalWeight")
            val totalWeight: Double,
            @SerializedName("uri")
            val uri: String,
            @SerializedName("url")
            val url: String,
            @SerializedName("yield")
            val yield: Double
        ) {
            data class Digest(
                @SerializedName("daily")
                val daily: Double,
                @SerializedName("hasRDI")
                val hasRDI: Boolean,
                @SerializedName("label")
                val label: String,
                @SerializedName("schemaOrgTag")
                val schemaOrgTag: String,
                @SerializedName("sub")
                val sub: List<Sub>,
                @SerializedName("tag")
                val tag: String,
                @SerializedName("total")
                val total: Double,
                @SerializedName("unit")
                val unit: String
            ) {
                data class Sub(
                    @SerializedName("daily")
                    val daily: Double,
                    @SerializedName("hasRDI")
                    val hasRDI: Boolean,
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("schemaOrgTag")
                    val schemaOrgTag: String,
                    @SerializedName("tag")
                    val tag: String,
                    @SerializedName("total")
                    val total: Double,
                    @SerializedName("unit")
                    val unit: String
                )
            }

            data class Ingredient(
                @SerializedName("text")
                val text: String,
                @SerializedName("weight")
                val weight: Double
            )

            data class TotalDaily(
                @SerializedName("CA")
                val cA: CA,
                @SerializedName("CHOCDF")
                val cHOCDF: CHOCDF,
                @SerializedName("CHOLE")
                val cHOLE: CHOLE,
                @SerializedName("ENERC_KCAL")
                val eNERCKCAL: ENERCKCAL,
                @SerializedName("FASAT")
                val fASAT: FASAT,
                @SerializedName("FAT")
                val fAT: FAT,
                @SerializedName("FE")
                val fE: FE,
                @SerializedName("FIBTG")
                val fIBTG: FIBTG,
                @SerializedName("FOLDFE")
                val fOLDFE: FOLDFE,
                @SerializedName("K")
                val k: K,
                @SerializedName("MG")
                val mG: MG,
                @SerializedName("NA")
                val nA: NA,
                @SerializedName("NIA")
                val nIA: NIA,
                @SerializedName("P")
                val p: P,
                @SerializedName("PROCNT")
                val pROCNT: PROCNT,
                @SerializedName("RIBF")
                val rIBF: RIBF,
                @SerializedName("THIA")
                val tHIA: THIA,
                @SerializedName("TOCPHA")
                val tOCPHA: TOCPHA,
                @SerializedName("VITA_RAE")
                val vITARAE: VITARAE,
                @SerializedName("VITB12")
                val vITB12: VITB12,
                @SerializedName("VITB6A")
                val vITB6A: VITB6A,
                @SerializedName("VITC")
                val vITC: VITC,
                @SerializedName("VITD")
                val vITD: VITD,
                @SerializedName("VITK1")
                val vITK1: VITK1,
                @SerializedName("ZN")
                val zN: ZN
            ) {
                data class CA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOCDF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOLE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ENERCKCAL(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FASAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FIBTG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FOLDFE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class K(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class MG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class P(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class PROCNT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class RIBF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class THIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class TOCPHA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITARAE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB12(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB6A(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITC(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITD(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITK1(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ZN(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )
            }

            data class TotalNutrients(
                @SerializedName("CA")
                val cA: CA,
                @SerializedName("CHOCDF")
                val cHOCDF: CHOCDF,
                @SerializedName("CHOLE")
                val cHOLE: CHOLE,
                @SerializedName("ENERC_KCAL")
                val eNERCKCAL: ENERCKCAL,
                @SerializedName("FAMS")
                val fAMS: FAMS,
                @SerializedName("FAPU")
                val fAPU: FAPU,
                @SerializedName("FASAT")
                val fASAT: FASAT,
                @SerializedName("FAT")
                val fAT: FAT,
                @SerializedName("FATRN")
                val fATRN: FATRN,
                @SerializedName("FE")
                val fE: FE,
                @SerializedName("FIBTG")
                val fIBTG: FIBTG,
                @SerializedName("FOLDFE")
                val fOLDFE: FOLDFE,
                @SerializedName("FOLFD")
                val fOLFD: FOLFD,
                @SerializedName("K")
                val k: K,
                @SerializedName("MG")
                val mG: MG,
                @SerializedName("NA")
                val nA: NA,
                @SerializedName("NIA")
                val nIA: NIA,
                @SerializedName("P")
                val p: P,
                @SerializedName("PROCNT")
                val pROCNT: PROCNT,
                @SerializedName("RIBF")
                val rIBF: RIBF,
                @SerializedName("SUGAR")
                val sUGAR: SUGAR,
                @SerializedName("THIA")
                val tHIA: THIA,
                @SerializedName("TOCPHA")
                val tOCPHA: TOCPHA,
                @SerializedName("VITA_RAE")
                val vITARAE: VITARAE,
                @SerializedName("VITB12")
                val vITB12: VITB12,
                @SerializedName("VITB6A")
                val vITB6A: VITB6A,
                @SerializedName("VITC")
                val vITC: VITC,
                @SerializedName("VITD")
                val vITD: VITD,
                @SerializedName("VITK1")
                val vITK1: VITK1,
                @SerializedName("WATER")
                val wATER: WATER,
                @SerializedName("ZN")
                val zN: ZN
            ) {
                data class CA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOCDF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class CHOLE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ENERCKCAL(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAMS(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAPU(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FASAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FAT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FATRN(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FIBTG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FOLDFE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class FOLFD(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class K(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class MG(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class NIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class P(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class PROCNT(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class RIBF(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class SUGAR(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class THIA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class TOCPHA(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITARAE(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB12(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITB6A(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITC(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITD(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class VITK1(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class WATER(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )

                data class ZN(
                    @SerializedName("label")
                    val label: String,
                    @SerializedName("quantity")
                    val quantity: Double,
                    @SerializedName("unit")
                    val unit: String
                )
            }
        }
    }
}