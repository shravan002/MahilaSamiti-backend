package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.TransactionDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.CollectionFrequency;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDao transactionDao;
    @Autowired
    MemberService memberService;
    @Autowired
    CommitteeService committeeService;

    Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    final long ZERO = 0;
    final long HUNDRED = 100;

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

//    /**
//     * Run this scheduler At 12:00 AM, only on Friday
//     */
//    @Scheduled(cron = "0 0 * * FRI")
//    public void markMemberForMinDueCalculationWeekly(){
//        log.info("Scheduler running:Marking members for Minimum due amount calculation.");
//        List<Member> members = memberService.getMembers();
//        for (Member member : members) {
//            if (member.getOutstandingAmount() > ZERO) {
//                Committee committee = member.getCommittee();
//                if(committee.getCollectionFrequency() == CollectionFrequency.WEEKLY)
//                    member.setMinDueEligibility(true);
//                    memberService.updateMember(member);
//            }
//        }
//    }
//
//    /**
//     *  Run this scheduler At 12:00 AM, on day 1 of the month
//     */
//    @Scheduled(cron = "0 0 1 * *")
//    public void markMemberForMinDueCalculationMonthly(){
//        log.info("Scheduler running:Marking members for Minimum due amount calculation.");
//        List<Member> members = memberService.getMembers();
//        for (Member member : members) {
//            if (member.getOutstandingAmount() > ZERO) {
//                Committee committee = member.getCommittee();
//                if(committee.getCollectionFrequency() == CollectionFrequency.MONTHLY){
//                    member.setMinDueEligibility(true);
//                    memberService.updateMember(member);
//                }
//            }
//        }
//    }
//
//    /**
//     * Run this scheduler Every Day at 2AM
//     */
//    @Scheduled(cron = "0 0 2 1/1 * *")
//    public void calculateMinimumDue() {
//        log.info("Minimum due amount calculator scheduler running.");
//        List<Member> members = memberService.getMembers();
//        for (Member member : members) {
//            Committee committee = member.getCommittee();
//            if (member.isMinDueEligibility()){
//                long currentMinDue = (committee.getMpr() * member.getOutstandingAmount()) / HUNDRED;
//                member.setMinimumDue(member.getMinimumDue() + currentMinDue);
//                member.setMinDueEligibility(false);
//                memberService.updateMember(member);
//            }
//        }
//    }

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
