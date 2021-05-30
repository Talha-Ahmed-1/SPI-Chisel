// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Tracing implementation internals
#include "verilated_vcd_c.h"
#include "VBlackBoxAdder__Syms.h"


//======================

void VBlackBoxAdder::trace (VerilatedVcdC* tfp, int, int) {
    tfp->spTrace()->addCallback (&VBlackBoxAdder::traceInit, &VBlackBoxAdder::traceFull, &VBlackBoxAdder::traceChg, this);
}
void VBlackBoxAdder::traceInit(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->open()
    VBlackBoxAdder* t=(VBlackBoxAdder*)userthis;
    VBlackBoxAdder__Syms* __restrict vlSymsp = t->__VlSymsp; // Setup global symbol table
    if (!Verilated::calcUnusedSigs()) vl_fatal(__FILE__,__LINE__,__FILE__,"Turning on wave traces requires Verilated::traceEverOn(true) call before time 0.");
    vcdp->scopeEscape(' ');
    t->traceInitThis (vlSymsp, vcdp, code);
    vcdp->scopeEscape('.');
}
void VBlackBoxAdder::traceFull(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->dump()
    VBlackBoxAdder* t=(VBlackBoxAdder*)userthis;
    VBlackBoxAdder__Syms* __restrict vlSymsp = t->__VlSymsp; // Setup global symbol table
    t->traceFullThis (vlSymsp, vcdp, code);
}

//======================


void VBlackBoxAdder::traceInitThis(VBlackBoxAdder__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    vcdp->module(vlSymsp->name()); // Setup signal names
    // Body
    {
	vlTOPp->traceInitThis__1(vlSymsp, vcdp, code);
    }
}

void VBlackBoxAdder::traceFullThis(VBlackBoxAdder__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vlTOPp->traceFullThis__1(vlSymsp, vcdp, code);
    }
    // Final
    vlTOPp->__Vm_traceActivity = 0U;
}

void VBlackBoxAdder::traceInitThis__1(VBlackBoxAdder__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->declQuad (c+1,"in1",-1,32,0);
	vcdp->declQuad (c+3,"in2",-1,32,0);
	vcdp->declQuad (c+5,"out",-1,33,0);
	vcdp->declQuad (c+1,"BlackBoxAdder in1",-1,32,0);
	vcdp->declQuad (c+3,"BlackBoxAdder in2",-1,32,0);
	vcdp->declQuad (c+5,"BlackBoxAdder out",-1,33,0);
    }
}

void VBlackBoxAdder::traceFullThis__1(VBlackBoxAdder__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->fullQuad (c+1,(vlTOPp->in1),33);
	vcdp->fullQuad (c+3,(vlTOPp->in2),33);
	vcdp->fullQuad (c+5,(vlTOPp->out),34);
    }
}
