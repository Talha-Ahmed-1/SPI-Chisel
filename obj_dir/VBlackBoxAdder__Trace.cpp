// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Tracing implementation internals
#include "verilated_vcd_c.h"
#include "VBlackBoxAdder__Syms.h"


//======================

void VBlackBoxAdder::traceChg(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->dump()
    VBlackBoxAdder* t=(VBlackBoxAdder*)userthis;
    VBlackBoxAdder__Syms* __restrict vlSymsp = t->__VlSymsp; // Setup global symbol table
    if (vlSymsp->getClearActivity()) {
	t->traceChgThis (vlSymsp, vcdp, code);
    }
}

//======================


void VBlackBoxAdder::traceChgThis(VBlackBoxAdder__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vlTOPp->traceChgThis__2(vlSymsp, vcdp, code);
    }
    // Final
    vlTOPp->__Vm_traceActivity = 0U;
}

void VBlackBoxAdder::traceChgThis__2(VBlackBoxAdder__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->chgQuad (c+1,(vlTOPp->in1),33);
	vcdp->chgQuad (c+3,(vlTOPp->in2),33);
	vcdp->chgQuad (c+5,(vlTOPp->out),34);
    }
}
