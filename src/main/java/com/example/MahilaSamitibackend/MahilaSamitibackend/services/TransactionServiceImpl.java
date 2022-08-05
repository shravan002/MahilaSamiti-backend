package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.TransactionDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDao transactionDao;
    @Autowired
    MemberService memberService;
    @Autowired
    CommitteeService committeeService;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        Member member = memberService.getMember(Long.parseLong(transaction.getMemberId()));
        Committee committee = member.getCommittee();
        long amount = transaction.getAmount();

        switch (transaction.getType()) {
            case MINIMUMDUEPAYMENT:
                minimumDuePayment(amount, member, committee);
                break;
            case OUTSTANDINGPAYMENT:
                outstandingAmountPayment(amount, member, committee);
                break;
            case CYCLICPAYMENT:
                cyclicPayment(amount, member, committee);
                break;
            case LOAN:
                sanctionLoan(amount, member, committee);
                break;
        }
        return transactionDao.save(transaction);
    }

    @Override
    public List<Transaction> getTransactions(String memberId) {
        return transactionDao.findTransactionByMemberId(memberId);
    }

    @Override
    public Member sanctionLoan(long amount, Member member, Committee committee) {
        committee.setLentAmount(committee.getLentAmount() + amount);
        committee.setTotalBalance(committee.getTotalBalance() - amount);
        committeeService.updateCommittee(committee);
        member.setOutstandingAmount(member.getOutstandingAmount() + amount);
        return memberService.updateMember(member);
    }

    @Override
    public Member outstandingAmountPayment(long amount, Member member, Committee committee) {
        committee.setLentAmount(committee.getLentAmount() - amount);
        committee.setTotalBalance(committee.getTotalBalance() + amount);
        committeeService.updateCommittee(committee);
        member.setOutstandingAmount(member.getOutstandingAmount() - amount);
        return memberService.updateMember(member);
    }

    @Override
    public Member minimumDuePayment(long amount, Member member, Committee committee) {
        committee.setInterestBalance(committee.getInterestBalance() + amount);
        committee.setTotalBalance(committee.getTotalBalance() + amount);
        committeeService.updateCommittee(committee);
        member.setMinimumDue(member.getMinimumDue() - amount);
        member.setInterestPaid(member.getInterestPaid() + amount);
        return memberService.updateMember(member);
    }

    @Override
    public Member cyclicPayment(long amount, Member member, Committee committee) {
        committee.setTotalBalance(committee.getTotalBalance() + amount);
        committee.setCyclicAmount(committee.getCyclicAmount() + amount);
        committeeService.updateCommittee(committee);
        member.setCyclicAmountPaid(member.getCyclicAmountPaid() + amount);
        return memberService.updateMember(member);
    }
}
