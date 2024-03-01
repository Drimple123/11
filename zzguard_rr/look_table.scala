package zzguardrr

import chisel3._
import chisel3.util._

class look_table1 extends Module{
  val io = IO(new Bundle{
    val addr      =   Input(UInt(2.W))
    val data_in   =   Input(UInt(2.W))
    val ren       =   Input(Bool())
    val wen       =   Input(Bool())
    val data_out  =   Output(UInt(2.W))
  })

  val table = SyncReadMem(4,UInt(2.W))

  io.data_out := table.read(io.addr,io.ren)
  when(io.wen === true.B){
    table.write(io.addr,io.data_in)
  }
}

// class look_table2 extends Module{
//   val io = IO(new Bundle{
//     val addr      =   Input(UInt(2.W))
//     val data_in   =   Input(UInt(2.W))
//     val ren       =   Input(Bool())
//     val wen       =   Input(Bool())
//     val data_out  =   Output(UInt(2.W))
//   })

//   val table = Mem(4,UInt(2.W))

//   io.data_out := table.read(io.addr,io.ren)
//   when(io.wen === true.B){
//     table.write(io.addr,io.data_in)
//   }
// }




