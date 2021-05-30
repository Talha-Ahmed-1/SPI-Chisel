// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Tracing implementation internals
#include "verilated_vcd_c.h"
#include "VBBox__Syms.h"


//======================

void VBBox::traceChg(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->dump()
    VBBox* t=(VBBox*)userthis;
    VBBox__Syms* __restrict vlSymsp = t->__VlSymsp; // Setup global symbol table
    if (vlSymsp->getClearActivity()) {
	t->traceChgThis (vlSymsp, vcdp, code);
    }
}

//======================


void VBBox::traceChgThis(VBBox__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vlTOPp->traceChgThis__2(vlSymsp, vcdp, code);
    }
    // Final
    vlTOPp->__Vm_traceActivity = 0U;
}

void VBBox::traceChgThis__2(VBBox__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->chgBit  (c+1,(vlTOPp->clock));
	vcdp->chgBit  (c+2,(vlTOPp->reset));
	vcdp->chgBus  (c+3,(vlTOPp->io_in1),32);
	vcdp->chgBus  (c+4,(vlTOPp->io_in2),32);
	vcdp->chgBus  (c+5,(vlTOPp->io_out),32);
	vcdp->chgBus  (c+6,((vlTOPp->io_in1 + vlTOPp->io_in2)),32);
	vcdp->chgQuad (c+7,((QData)((IData)(vlTOPp->io_in1))),33);
	vcdp->chgQuad (c+9,((QData)((IData)(vlTOPp->io_in2))),33);
	vcdp->chgQuad (c+11,((VL_ULL(0x3ffffffff) & 
			      ((QData)((IData)(vlTOPp->io_in1)) 
			       + (QData)((IData)(vlTOPp->io_in2))))),34);
    }
}
