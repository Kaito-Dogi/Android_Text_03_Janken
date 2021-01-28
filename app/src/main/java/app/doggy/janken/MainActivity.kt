package app.doggy.janken

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //手を用意。
    val hands: List<String> = listOf("グー", "チョキ", "パー")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //クリックリスナを設定。
        gooButton.setOnClickListener(OnClickListener())
        chokiButton.setOnClickListener(OnClickListener())
        paButton.setOnClickListener(OnClickListener())

    }

    private inner class OnClickListener: View.OnClickListener {
        override fun onClick(view: View) {

            //CPUの手を決定。
            var cpuHand: Int = Random.nextInt(3)

            //CPUの手を表示。
            cpuTextView.text = hands[cpuHand]

            //ボタンのidに応じて処理を変更。
            when(view.id) {
                R.id.gooButton -> {

                    //プレイヤーの手をTextViewに表示。
                    playerTextView.text = "グー"

                    //勝敗判定。
                    when(hands[cpuHand]) {
                        "グー" -> {
                            resultTextView.text = "あいこ！"
                        }
                        "チョキ" -> {
                            resultTextView.text = "あなたの勝ち！"
                        }
                        "パー" -> {
                            resultTextView.text = "CPUの勝ち！"
                        }
                    }
                }

                R.id.chokiButton -> {

                    //プレイヤーの手をTextViewに表示。
                    playerTextView.text = "チョキ"

                    //勝敗判定。
                    when(hands[cpuHand]) {
                        "グー" -> {
                            resultTextView.text = "CPUの勝ち！"
                        }
                        "チョキ" -> {
                            resultTextView.text = "あいこ！"
                        }
                        "パー" -> {
                            resultTextView.text = "あなたの勝ち！"
                        }
                    }
                }

                R.id.paButton -> {

                    //プレイヤーの手をTextViewに表示。
                    playerTextView.text = "パー"

                    //勝敗判定。
                    when(hands[cpuHand]) {
                        "グー" -> {
                            resultTextView.text = "あなたの勝ち！"
                        }
                        "チョキ" -> {
                            resultTextView.text = "CPUの勝ち！"
                        }
                        "パー" -> {
                            resultTextView.text = "あいこ！"
                        }
                    }
                }
            }

            //勝敗に応じて、resultTextViewの文字色を変更。
            when(resultTextView.text) {
                "あなたの勝ち！" -> {
                    resultTextView.setTextColor(Color.parseColor("#0000dd"))
                }

                "CPUの勝ち！" -> {
                    resultTextView.setTextColor(Color.parseColor("#dd0000"))
                }

                "あいこ！" -> {
                    resultTextView.setTextColor(Color.parseColor("#00dd00"))
                }
            }
        }
    }
}